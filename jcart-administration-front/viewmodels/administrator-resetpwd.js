var app = new Vue({
    el: '#app',
    data: {
        email: '',
        resetCode: '',
        newPwd: '',
        reNewPwd: ''
    },
    methods: {
        handleResetPwdClick() {
            console.log('reset pwd click');

            if(this.newPwd !== this.reNewPwd){
                alert('密码不一致');
                return;
            }
        }
    }
})