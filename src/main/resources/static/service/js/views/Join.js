import {EVENT_TYPE} from "../../utils/constants.js";
import api from "../../api/Login.js"

function Join() {
    const $joinButton = document.querySelector("#join-button")
    const $newMemberEmail = document.querySelector("#email")
    const $newMemberName = document.querySelector("#name")
    const $newMemberPassword = document.querySelector("#password")


    const onCreateMember = async event => {
        event.preventDefault();
        const memberForm = {
            email: $newMemberEmail.value,
            name: $newMemberName.value,
            password: $newMemberPassword.value
        }

        await api.member
            .create(memberForm)
            .then(res => console.log(res))
            .catch(err => console.log(err.message));

        await api.loginMember
            .login({
                email: $newMemberEmail.value,
                password: $newMemberPassword.value
            })
            .then(res => console.log(res))
            .catch(err => console.log(err.message));

        window.location.href = "/map";
    }

    this.init = () => {
        $joinButton.addEventListener(EVENT_TYPE.CLICK, onCreateMember)
    }
}

const join = new Join();
join.init();