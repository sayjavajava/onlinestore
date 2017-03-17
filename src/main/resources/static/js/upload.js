/**
 * Created by waqas on 09/03/2017.
 */

    // bind the on-change event for the input element (triggered when a file
    // is chosen)
    $(document).ready(function() {
        $("#upload-file-submit").on("click", uploadFile);
       // alert('hello');
    });

/**
 * Upload the file sending it via Ajax at the Spring Boot server.
 */
function uploadFile() {
    $.ajax({
        url: "/uploadFile",
        type: "POST",
        data: new FormData($("#upload-file-form")[0]),
        enctype: 'multipart/form-data',
        processData: false,
        contentType: false,
        cache: false,
        success: function () {
            // Handle upload success
            $("#upload-file-message").text("File succesfully uploaded").addClass("alert alert-success");
            console.log("great");
        },
        error: function () {
            // Handle upload error
            $("#upload-file-message").text(
                "File not uploaded (perhaps it's too much big)".addClass("alert alert-danger"));
        }
    });
} // function uploadFile
