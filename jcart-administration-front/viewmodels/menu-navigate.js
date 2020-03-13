var app = new Vue({
    router: router,
    el: '#app',
    data: {
        subMenus: [
            {
                name: '商品管理',
                index: '1',
                icon: 'el-icon-goods',
                menuItems: [
                    { name: '商品列表', index: '1-1', route: '/product/search' }
                ]
            }
        ]
    },
    methods: {
    }
})