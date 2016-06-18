var blogModule = angular.module('blog', ['ui.router', 'ui.bootstrap']);

blogModule.controller('testCtrl', function($scope){
    $scope.id = 1;
});