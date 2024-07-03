document.addEventListener("DOMContentLoaded", function() {
    const emailInput = document.querySelector("input[name='email']");
    const checkEmailButton = document.getElementById("check-email");
    const emailCheckHidden = document.querySelector("input[name='emailCheck']");
    const form = document.getElementById("join-form");
    const agreeCheckbox = document.getElementById("agree");
    const nameInput = document.querySelector("input[name='name']");
    const passwordInput = document.querySelector("input[name='password']");
    const emailCheckMessage = document.createElement("div");
    emailCheckMessage.id = "emailCheckMessage";
    emailInput.parentNode.insertBefore(emailCheckMessage, emailInput.nextSibling);

    checkEmailButton.addEventListener("click", function() {
        const email = emailInput.value;
        const targetUrl = checkEmailButton.getAttribute("data-target");

        if (email) {
            fetch(targetUrl + '?email=' + encodeURIComponent(email))
                .then(response => {
                    if (!response.ok) {
                        throw new Error("Network response was not ok");
                    }
                    return response.json();
                })
                .then(data => {
                    if (data) {
                        emailCheckMessage.textContent = "이 이메일은 이미 사용 중입니다.";
                        emailCheckMessage.style.color = "red";
                        emailCheckHidden.value = "n";
                    } else {
                        emailCheckMessage.textContent = "이 이메일은 사용 가능합니다.";
                        emailCheckMessage.style.color = "green";
                        emailCheckHidden.value = "y";
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    emailCheckMessage.textContent = "이메일 확인 중 오류가 발생했습니다.";
                    emailCheckMessage.style.color = "red";
                });
        } else {
            emailCheckMessage.textContent = "이메일을 입력해 주세요.";
            emailCheckMessage.style.color = "red";
        }
    });

    form.addEventListener("submit", function(event) {
        if (!nameInput.value) {
            alert("이름을 입력해 주세요.");
            nameInput.focus();
            event.preventDefault();
            return;
        }

        if (!passwordInput.value) {
            alert("비밀번호를 입력해 주세요.");
            passwordInput.focus();
            event.preventDefault();
            return;
        }

        if (emailCheckHidden.value !== "y") {
            alert("이메일 중복 체크를 완료해 주세요.");
            emailInput.focus();
            event.preventDefault();
            return;
        }

        if (!agreeCheckbox.checked) {
            alert("약관에 동의해야 합니다.");
            agreeCheckbox.focus();
            event.preventDefault();
        }
    });
});
