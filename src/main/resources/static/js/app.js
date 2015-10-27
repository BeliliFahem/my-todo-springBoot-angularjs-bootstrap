var app = angular.module("MyTodo", []);

app.controller("todoCtrl", function($scope, $http) {
	$scope.todoList = [];
	$scope.keyWord = null;
	$scope.pages = [];
	$scope.currentPage = 0;

	$scope.getAllTodo = function() {
		$http.get("all").success(function(data, status, headers, config) {
			$scope.todoList = data;
			$scope.pages = [];
		});
	};

	$scope.searchByKeWord = function(pageIndex) {
		$http.get("todoListByKeyWord?kw=" + $scope.keyWord + "&pageNbr="+pageIndex)
				.success(function(data, status, headers, config) {
					$scope.todoList = data.content;
					$scope.pages = new Array(data.totalPages);
					$scope.currentPage = pageIndex;
				});
	};
	

});