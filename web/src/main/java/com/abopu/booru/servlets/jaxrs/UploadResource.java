package com.abopu.booru.servlets.jaxrs;

import com.abopu.booru.config.PathHelper;
import org.apache.commons.codec.binary.Hex;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sarah Skanes
 * @created May 16, 2016.
 */
@Path("/upload")
public class UploadResource {

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public List<FileUploadResponse> uploadFiles(FormDataMultiPart formData) {
		List<FileUploadResponse> files = formData.getFields("files").parallelStream().map(LambdaExceptionUtil.rethrowFunction(this::handleUpload)).collect(Collectors.toList());
		return files;
	}

	private FileUploadResponse handleUpload(FormDataBodyPart fileData) throws Exception {
		String fileName = fileData.getContentDisposition().getFileName();
		java.nio.file.Path tempFile = Files.createTempFile(fileName, String.valueOf(new Date().getTime()));

		FileUploadResponse fileUploadResponse = new FileUploadResponse();
		fileUploadResponse.setOriginalName(fileName);

//		java.nio.file.Path location = Paths.get(Configuration.getDataDir(), "uploads", fileName);
		try {
			InputStream in = fileData.getValueAs(InputStream.class);
			OutputStream out = Files.newOutputStream(tempFile);

			MessageDigest digest = MessageDigest.getInstance("MD5");
			
			int bytesRead;
			byte[] buffer = new byte[2048];
			while ((bytesRead = in.read(buffer)) != -1) {
				digest.update(buffer, 0, bytesRead);
				out.write(buffer, 0, bytesRead);
			}

			byte[] digestResult = digest.digest();
//			StringBuilder sb = new StringBuilder();
//			for (int i = 0; bytesRead < digestResult.length; i++) {
//				sb.append(Integer.toString((digestResult[i] & 0xff) + 0x100, 16).substring(1));
//			}
			
			String md5 = Hex.encodeHexString(digestResult);
			fileUploadResponse.setMD5(md5);
			
			String level1 = md5.substring(0,2);
			String level2 = md5.substring(2,4);
			String level3 = md5.substring(4,6);

			java.nio.file.Path targetFolder = PathHelper.uploadDir().resolve(level1).resolve(level2).resolve(level3);
			Files.createDirectories(targetFolder);

			String extension = fileName.substring(fileName.lastIndexOf('.'));
			String newFileName = md5 + extension;

			java.nio.file.Path targetFile = targetFolder.resolve(newFileName);

			Files.copy(tempFile, targetFile);
			if (Files.exists(targetFolder)) {
				Files.delete(tempFile);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return fileUploadResponse;
	}


	private class FileUploadResponse {
		
		private String MD5;
		private String originalName;

		public String getMD5() {
			return MD5;
		}

		public void setMD5(String MD5) {
			this.MD5 = MD5;
		}

		public String getOriginalName() {
			return originalName;
		}

		public void setOriginalName(String originalName) {
			this.originalName = originalName;
		}
	}
}
