'use strict';

App.controller('bookController', ['$scope', 'bookService','categoryService', function($scope, bookService,categoryService) {
          var self = this;
          self.book={isbn:'',name:'',price:null,description:'',author:'',editor:'',category:{name:''}};
          self.books=[];
          self.categories=[];
          self.keyword="";
          self.oneBook={isbn:'',name:'',price:null,description:'',author:'',editor:''};
          self.bookDetails={isbn:'',name:'',price:null,author:'',editor:''};

          self.fetchAllCategories = function(){
        	  categoryService.fetchAllCategories()
                  .then(
      					       function(d) {
      						        self.categories = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
          
          self.fetchAllBooks = function(){
              bookService.fetchAllBooks()
                  .then(
      					       function(d) {
      						        self.books = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
          self.fetchBookByISBN = function(isbn){
              bookService.fetchBookByISBN(isbn)
                  .then(
      					       function(d) {
      						        self.oneBook = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching Currencies');
            					}
      			       );
          };
          
          self.fetchBooksByKeyWord = function(){
              bookService.fetchBooksByKeyWord($scope.keyword)
                  .then(
      					       function(d) {
      						        self.books = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching books by keyword');
            					}
      			       );
          };
          self.serchBookByDetails = function(){
        	  console.log(">>>controller bookDetails:"+$scope.bookDetails.name)
              bookService.serchBookByDetails($scope.bookDetails)
                  .then(
      					       function(d) {
      						        self.books = d;
      					       },
            					function(errResponse){
            						console.error('Error while fetching books by keyword');
            					}
      			       );
          };
           
          self.createBook = function(book){
              bookService.createBook(book)
		              .then(
                      self.fetchAllBooks, 
				              function(errResponse){
					               console.error('Error while creating Book.');
				              }	
                  );
          };

         self.updateBook = function(book, isbn){
              bookService.updateBook(book, isbn)
		              .then(
				              self.fetchAllBooks, 
				              function(errResponse){
					               console.error('Error while updating Book.');
				              }	
                  );
          };

         self.deleteUser = function(isbn){
              bookService.deleteBook(isbn)
		              .then(
				              self.fetchAllBooks, 
				              function(errResponse){
					               console.error('Error while deleting Book.');
				              }	
                  );
          };

          self.fetchAllBooks();
          self.fetchAllCategories();

          self.submit = function() {
//              if(self.book.isbn==null){
                  console.log('Saving New Book', self.book);    
                  self.createBook(self.book);
//              }else{
//                  self.updateBook(self.book, self.book.isbn);
//                  console.log('User updated with id ', self.book.isbn);
//              }
              self.reset();
          };
              
          self.edit = function(isbn){
              console.log('id to be edited', isbn);
              for(var i = 0; i < self.books.length; i++){
                  if(self.books[i].isbn == isbn) {
                     self.book = angular.copy(self.books[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(isbn){
              console.log('id to be deleted', isbn);
              if(self.book.isbn === isbn) {//clean form if the book to be deleted is shown there.
                 self.reset();
              }
              self.deleteBook(isbn);
          };

          
          self.reset = function(){
              self.book={isbn:'',name:'',price:null,description:'',author:'',editor:''};
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);