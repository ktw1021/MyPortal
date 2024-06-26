function confirmDelete(no) {
    if (confirm("정말로 삭제하시겠습니까?")) {
        window.location.href = "/myportal/board/delete/" + no;
    }
}

function validateForm(formName) {
    var title = document.forms[formName]["title"].value;
    var content = document.forms[formName]["content"].value;
    if (title == null || title == "") {
        alert("제목을 입력하십시오.");
        document.forms[formName]["title"].focus();
        return false;
    }
    if (content == null || content == "") {
        alert("내용을 입력하십시오.");
        document.forms[formName]["content"].focus();
        return false;
    }
    return true;
}
