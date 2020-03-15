const routes = [
    { path: '/product/search', component: ProductSearchRoutePage },
    { path: '/product/create', component: ProductCreateRoutePage },
    { path: '/product/update/:productId', component: ProductUpdateRoutePage }

];

const router = new VueRouter({
    routes: routes
});