'use strict';

App
    .controller(
        'checkoutController',
        [
            '$scope',
            '$location',
            'bookService',
            'userService',
            'checkoutService',
            '$cookieStore',
            function ($scope, $location, bookService,userService,checkoutService,$cookies) {
                var self = this;
                self.init = function(){
        			if(!($cookies.get("cart") instanceof Array)){
        				$cookies.put("cart", [], {path: '/bookStore'});
        			}
        		};
        		self.init();
                self.cart = [];
                self.cartBooks = [];
                self.errorlogin=false;
                $scope.loginUser={};
                $scope.commandSucceded=false;
                $scope.loggedUserName={};
                self.commandedBooks = {};
                self.keyword = "";
                self.searchedBooks = [];
                self.authenticated=userService.getLoggedUser().then(
                        function (d) {
                            if(d.username!=null){
                            	$scope.loggedUserName=d.username;
                            	self.authenticated=true;
                            }else{
                            	self.authenticated=false;
                            }
                        },
                        function (errResponse) {
                            console
                                .error('Error while fetching Currencies');
                        });
                $scope.redirect = function (keyword) {
                    $location.path('/booksearch/' + keyword);
                }
                self.getTotal = function () {
                    var sum = 0;
                    for (var i = 0, len = self.commandedBooks.orderRawList.length; i < len; i++) {
                        sum += self.commandedBooks.orderRawList[i].qte
                            * self.commandedBooks.orderRawList[i].book.price;
                    }
                    return sum;
                };

                self.order = function () {
                	if(self.authenticated){
                		checkoutService
                        .checkout(self.commandedBooks)
                        .then(
                            function (d) {
                            	$scope.commandSucceded=true;
                            	$cookies.remove("cart");
                        		self.cart=[];
                        		self.cartBooks = [];
                        		self.commandedBooks = {};
                            	$location.path("/");                                
                            },
                            function (errResponse) {
                                console
                                    .error('Error while passing cmd');
                            });
                }else{
                	$location.path("/login");
                }
                	};
                self.addToCart = function (isbn, price) {
                	if(!($cookies.get("cart") instanceof Array)){
        				$cookies.put("cart", [], {path: '/bookStore'});
        			}
                	self.cart=$cookies.get("cart");
        			//si l'item n'existe pas on l'ajoute
        			if(self.cart.indexOf(isbn) == -1)
        				{
        					self.cart.push(isbn);
        					$cookies.put("cart",self.cart);
        				}
                }
                self.findBooksByIsbn = function () {
                	self.cart=$cookies.get("cart");
                    bookService.findBooksByIsbn(self.cart)
                        .then(
                            function (d) {
                                self.cartBooks = d;
                                self.commandedBooks={"orderRawList":[]};
                                for (var i = 0, len = self.cart.length; i < len; i++) {
                                self.commandedBooks.orderRawList.push({book:d[i],qte:1});
                                }
                              },
                            function (errResponse) {
                                console
                                    .error('Error while fetching commanded books');
                            });
                };
                self.remove=function(isbn,num){
                	var index = self.cartBooks.indexOf(isbn);
          		  self.cartBooks.splice(index, 1);
          		var index=self.commandedBooks.orderRawList.splice(num,1);
                }
                self.clearCoockies=function(){
                	$cookies.remove("cart");
            		self.cart=[];
            		self.cartBooks = [];
            		self.searchedBooks = [];
            		self.commandedBooks = {};
                  }
            }

        ]);