var app = new Vue({
    el: '#app',
    data: {
        email: '',
        restCode: '',
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
            this.resetAdministratorPwd();
        },
        resetAdministratorPwd() {
            axios.post('/administrator/restPwd', {
                email: this.email,
                restCode: this.restCode,
                newPwd: this.newPwd
            })
                .then(function (response) {
                    console.log(response);
                    alert('重置成功');
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})