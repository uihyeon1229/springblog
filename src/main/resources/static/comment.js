'use strict';

let replyIndex = {
    init: function () {
        $("#reply-btn-save").on("click", () => {
            this.replySave();
        });
    },

    replySave: function () {
        let data = {
            content: $("#reply-content").val(),
        }
        let blogId = $("#blogId").val();
        console.log(data);
        console.log(blogId);
        $.ajax({
            type: "POST",
            url: `/api/blog/${blogId}/comments`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "text"
        }).done(function (res) {
            alert("댓글작성이 완료되었습니다.");
            location.href = `/api/blog/${id}`;
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },

}
replyIndex.init();