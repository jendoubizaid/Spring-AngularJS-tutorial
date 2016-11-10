'use strict';

var App = angular.module('myApp',['ngRoute','ngCookies']);
App.config(function($routeProvider){
	$routeProvider
		.when('/',{controller:'bookController as ctrl',templateUrl:'/jebouquine/partials/books' })
		.when('/bookDetails/:isbn',{controller:'bookDetailsController',templateUrl:'/jebouquine/partials/bookDetails' })
		.when('/booksearch/:key',{controller:'searchBookController',templateUrl:'/jebouquine/partials/booksByKeyword' })
		.when('/theme/:cat',{controller:'searchBookController',templateUrl:'/jebouquine/partials/booksByCategory' })
		.when('/login',{templateUrl:'/jebouquine/partials/login' })
		.when('/signup',{controller:'UserController',templateUrl:'/jebouquine/partials/signup' })
		.when('/checkout',{templateUrl:'/jebouquine/partials/checkout' })
		.otherwise({redirectTo:'/'})
});



