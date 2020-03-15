const ProductUpdateRoutePage = {
    template: ``,
    data() {
        return {
            productId: '',
            productCode: '',
            productName: '',
            price: '',
            discount: '',
            stockQuantity: '',
            rewordPoints: '',
            sortOrder: '',
            productAbstract: '',
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

        this.productId = this.$route.params.productId;
        if (!this.productId) {
            alert('productId is null');
            return;
        }
    },
    methods: {
        handleGoBack() {
            console.log('go back click');
            this.$router.back();
        },
        handleUpdateClick() {
            console.log('update click');
            this.description = tinyMCE.activeEditor.getContent();
            this.updateProduct();
        },
        updateProduct() {
            axios.post('/product/update', {
                productId: this.productId,
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
                .then((response) => {
                    console.log(response);
                    alert('修改成功');
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
}