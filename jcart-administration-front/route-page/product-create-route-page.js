const ProductCreateRoutePage = {
    template: ``,
    data() {
        return {
        productCode: '',
        productName: '',
        price: '',
        discount: '',
        stockQuantity: '',
        rewordPoints: '',
        sortOrder: '',
        description: '',
        selectedStatus: 1,
        selectedMainPic: '',
        mainPicUrl: '',
        selectedOtherPics: [],
        otherPicUrls: [],
        statuses: [
            { value: 0, label: '下架' },
            { value: 1, label: '上架' },
            { value: 2, label: '待审核' }
        ],
        mainFileList: [],
        otherFileList: []
        }
    },
    mounted() {
        console.log('view mounted');
        tinymce.init({
            selector: '#mytextarea'
        });
    },
    methods: {
        handleTabClick(tab, event) {
            console.log('tab click', tab, event);
        },
        handleGoBack() {
            console.log('go back click');
            this.$router.back();
        },
        handleCreateClick() {
            console.log('create click');
            this.description = tinyMCE.activeEditor.getContent();
            this.createProduct();
        },
        createProduct() {
            axios.post('/product/create', {
                productCode: this.productCode,
                productName: this.productName,
                price: this.price,
                discount: this.discount,
                stockQuantity: this.stockQuantity,
                status: this.selectedStatus,
                mainPicUrl: this.mainPicUrl,
                rewordPoints: this.rewordPoints,
                sortOrder: this.sortOrder,
                productAbstract: this.productAbstract,
                description: this.description,
                otherPicUrls: this.otherPicUrls
            })
                .then(function (response) {
                    console.log(response);
                    alert('创建成功');
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
}