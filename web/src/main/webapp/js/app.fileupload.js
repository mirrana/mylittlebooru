$(function () {
    'use strict';

    // Initialize the jQuery File Upload widget:
    $('#fileupload').fileupload({
        url: '/rapi/upload/',
        // disableImageResize: /Android(?!.*Chrome)|Opera/.test(window.navigator.userAgent),
        // maxFileSize: 999000,
        // acceptFileTypes: /(\.|\/)(bmp|gif|jpe?g|png|webm|svg)$/i,
        dataType: 'json',
        singleFileUploads: false,
        
        done: function (e, data) {
            alert('foo');
            // $.each(data.result.files, function (index, file) {
            //     $('<p/>').text(file.name).appendTo(document.body);
            // });
        }
    });

    // $('#fileupload').bind('fileuploaddone', function (e, data) {
    //     debugger;
    // });
    //
    // $('#fileupload').bind('fileuploadfail', function (e, data) {
    //     debugger;
    // });

    // Upload server status check for browsers with CORS support:
    // if ($.support.cors) {
    //     $.ajax({
    //         url: '//jquery-file-upload.appspot.com/',
    //         type: 'HEAD'
    //     }).fail(function () {
    //         $('<div class="alert alert-danger"/>')
    //             .text('Upload server currently unavailable - ' +
    //                 new Date())
    //             .appendTo('#fileupload');
    //     });
    // }


    // if (window.location.hostname === 'blueimp.github.io') {
    //     // Demo settings:
    // } else {
    //     // Load existing files:
    //     $('#fileupload').addClass('fileupload-processing');
    //     $.ajax({
    //         // Uncomment the following to send cross-domain cookies:
    //         //xhrFields: {withCredentials: true},
    //         url: $('#fileupload').fileupload('option', 'url'),
    //         dataType: 'json',
    //         context: $('#fileupload')[0]
    //     }).always(function () {
    //         $(this).removeClass('fileupload-processing');
    //     }).done(function (result) {
    //         $(this).fileupload('option', 'done')
    //             .call(this, $.Event('done'), {result: result});
    //     });
    // }

});