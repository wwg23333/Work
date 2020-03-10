var app = new Vue({
    el: '#app',
    data: {
        returnId: '',
        returnHistories: [],
        selectedReturnStatus: '',
        returnStatuses: [
            { value: 1, label: '待取货' },
            { value: 2, label: '正在处理' },
            { value: 3, label: '已完成' }
        ],
        customerNotified: false,
        comment: ''
    },
    mounted() {
        console.log('view mounted');

        var url = new URL(location.href);
        this.returnId = url.searchParams.get("returnId");
        if (!this.returnId) {
            alert('returnId is null');
            return;
        }

        this.getHistoryByReturnId();
    },
    methods: {
        getHistoryByReturnId() {
            axios.get('/returnhistory/getListByReturnId', {
                params: {
                    returnId: this.returnId
                }
            })
                .then(function (response) {
                    console.log(response);
                    app.returnHistories = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})