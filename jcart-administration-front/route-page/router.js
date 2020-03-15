const routes = [
    { path: '/product/search', component: ProductSearchRoutePage },
    { path: '/product/create', component: ProductCreateRoutePage },
    { path: '/product/update', component: ProductUpdateRoutePage }

];

const router = new VueRouter({
    routes: routes
});