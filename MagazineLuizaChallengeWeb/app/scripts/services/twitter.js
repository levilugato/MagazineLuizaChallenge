(function() {
  'use strict';

  angular.module('magazineLuizaChallengeWebApp')
    .service('TwitterService', TwitterService);

  TwitterService.$inject = ['$http', 'Config'];

  function TwitterService($http, Config){

  	var service = {
      listarTweets: listarTweets,
      logarTwittes: logarTwittes 
  	};

  	return service

    function listarTweets(username){
      return $http({
          method: 'GET',
          url: Config.API_CONTEXT + "api/twitter/" + username
        });
    }

    function logarTwittes(infoLogs){
      console.log(infoLogs);
      return $http({
          method: 'POST',
          url: Config.API_CONTEXT + "api/twitter",
          data: infoLogs
        });
    }

   }

  })();