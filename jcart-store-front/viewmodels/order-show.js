var app = new Vue({
    el: '#app',
    data: {
        orderId: '',
        status: '',
        totalPrice: '',
        rewordPoints: '',
        createTimestamp: '',
        updateTimestamp: '',
        shipMethod: '',
        shipAddress: '',
        shipPrice: '',
        payMethod: '',
        invoiceAddress: '',
        invoicePrice: '',
        comment: '',
        orderProducts: [],
        statuses: [
            { value: 0, label: '待处理' },
            { value: 1, label: '处理中' },
            { value: 2, label: '待发货' },
            { value: 3, label: '已发货' },
            { value: 4, label: '待签收' },
            { value: 5, label: '已签收' },
            { value: 6, label: '待支付' },
            { value: 7, label: '已支付' }
        ],
        shipMethods: [
            { value: 0, label: '顺丰' },
            { value: 1, label: '圆通' },
            { value: 2, label: '中通' },
            { value: 3, label: '申通' }
        ],
        payMethods: [
            { value: 0, label: '货到付款' },
            { value: 1, label: '微信支付' },
            { value: 2, label: '支付宝' }
        ]
    },
    mounted() {
        console.log('view mounted');

        var url = new URL(location.href);
        this.orderId = url.searchParams.get("orderId");
        if (!this.orderId) {
            alert('orderId is null');
            return;
        }

        this.getOrderById();
    },
    methods: {
        getOrderById() {
           
        }
    }
})