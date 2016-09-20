'use strict';

/**
 * @ngdoc overview
 * @name magazineLuizaChallengeWebApp
 * @description
 * # magazineLuizaChallengeWebApp
 *
 * Main module of the application.
 */
angular
  .module('magazineLuizaChallengeWebApp', [
    'ngAnimate',
    'ngMessages',
    'ngResource',
    'ngRoute',
    'ngSanitize'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/twitter', {
            templateUrl: 'views/twitter.html',
            controller: 'TwitterController',
            controllerAs: 'vm'
          })
      .otherwise({
        redirectTo: '/'
      });
  });
