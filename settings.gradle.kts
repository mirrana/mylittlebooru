rootProject.name = "mylittlebooru"

include(
        "web",
        "mobile",
        "data-manager"
)

for (project in rootProject.children) {
    project.apply {
        projectDir = file("modules/$name")
        require(projectDir.isDirectory) { "Project '${project.path} must have a $projectDir directory" }
        require(buildFile.isFile) { "Project '${project.path} must have a $buildFile build script" }
    }
}
