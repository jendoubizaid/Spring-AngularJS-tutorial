'use strict';

App.factory('bookService', ['$http', '$q', function($http, $q){

	return {
		
			fetchAllBooks: function() {
					return $http.get('/jebouquine/rest/book/')
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while fetching books');
										return $q.reject(errResponse);
									}
							);
			},fetchBookByISBN: function(isbn) {
				return $http.get('/jebouquine/rest/book/'+isbn)
				.then(
						function(response){
							return response.data;
						}, 
						function(errResponse){
							console.error('Error while fetching books');
							return $q.reject(errResponse);
						}
				);
},
		    
		    createBook: function(book,categoryName){
		    		console.log(">>>>>service:"+categoryName);
					return $http.post('/jebouquine/rest/book/', book)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating book');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		    updateBook: function(book, id){
					return $http.put('/jebouquine/rest/book/'+id, book)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while updating book');
										return $q.reject(errResponse);
									}
							);
			},
		    
			deleteBook: function(id){
				
					return $http.delete('/jebouquine/rest/book/'+id)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while deleting book');
										return $q.reject(errResponse);
									}
							);
			},fetchBooksByKeyWord: function(keyword) {
				return $http.post('/jebouquine/rest/book/ByKeyWord/'+keyword)
				.then(
						function(response){
							return response.data;
						}, 
						function(errResponse){
							console.error('Error while fetching books');
							return $q.reject(errResponse);
						}
				);
			},serchBookByDetails: function(bookDetails){
				console.log(">>>>service "+bookDetails);
				return $http.post('/jebouquine/rest/book/ByDetails/',bookDetails)
						.then(
								function(response){
									return response.data;
								}, 
								function(errResponse){
									console.error('Error while fetching book by details');
									return $q.reject(errResponse);
								}
						);
	    },findBooksByIsbn: function(listIsbn){
			console.log(">>>>service "+listIsbn);
			return $http.get('/jebouquine/rest/listBookById/'+listIsbn)
					.then(
							function(response){
								return response.data;
							}, 
							function(errResponse){
								console.error('Error while fetching books by isbn');
								return $q.reject(errResponse);
							}
					);
	    },fetchBooksByCat:function(cat){
	    	return $http.get('/jebouquine/rest/BooksByCat/'+cat)
			.then(
					function(response){
						return response.data;
					}, 
					function(errResponse){
						console.error('Error while searching by category');
						return $q.reject(errResponse);
					}
			);
	    }
	};


	    }]);
