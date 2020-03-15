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

        this.getProductById();
    },
    methods: {
        handleUpdateClick() {
            console.log('update click');
            this.description = tinyMCE.activeEditor.getContent();
            this.updateProduct();
        },
        handleOnMainChange(val) {
            this.selectedMainPic = val.raw;
        },
        handleUploadMainClick() {
            console.log('upload main pic click');
            this.uploadMainImage();
        },
        uploadMainImage() {
            var formData = new FormData();
            formData.append("image", this.selectedMainPic);

            axios.post('/image/upload', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            })
                .then((response) => {
                    console.log(response);
                    this.mainPicUrl = response.data;
                    alert('上传成功');
                })
                .catch(function (error) {
                    console.log(error);
                    alert('上传失败');
                });
        },
        handleOnOtherChange(file, fileList) {
            console.log('fileList', fileList);
            this.selectedOtherPics = fileList;
        },
        handleOnOtherRemove(file, fileList) {
            console.log('fileList', fileList);
            this.selectedOtherPics = fileList;
        },
        handleUploadOtherClick() {
            console.log('upload other pic click');
            this.uploadOtherImage();
        },
        uploadOtherImage() {
            this.selectedOtherPics.forEach(pic => {
                var formData = new FormData();
                formData.append("image", pic.raw);

                axios.post('/image/upload', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                })
                    .then((response) => {
                        console.log(response);
                        var url = response.data;
                        this.otherPicUrls.push(url);
                    })
                    .catch(function (error) {
                        console.log(error);
                        alert('上传失败');
                    });
            });


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
        },
        getProductById() {
            axios.get('/product/getById', {
                params: {
                    productId: this.productId
                }
            })
                .then((response) => {
                    console.log(response);
                    var product = response.data;
                    this.productId = product.productId;
                    this.productCode = product.productCode;
                    this.productName = product.productName;
                    this.price = product.price;
                    this.discount = product.discount;
                    this.stockQuantity = product.stockQuantity;
                    this.selectedStatus = product.status;
                    this.rewordPoints = product.rewordPoints;
                    this.sortOrder = product.sortOrder;
                    this.mainPicUrl = product.mainPicUrl;
                    this.productAbstract = product.productAbstract;
                    this.description = product.description;
                    tinymce.init({
                        selector: '#mytextarea'
                    });
                    this.otherPicUrls = product.otherPicUrls;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
}