loginapp.controller('loginCtrl', function($scope, $http) {

    $scope.login = function() {
    	var userName = $scope.userName;
		debugger;
    	$http.post('www.baidu.com', {
    		userName: $scope.userName,
    		password: $scope.password,
    		verifycode: $scope.verifycode
    	}).success(function(response) {
    		var code = response.code;
    	});
    }
});