(function() {
  'use strict';

	 angular.module('magazineLuizaChallengeWebApp')
	      .controller('TwitterController', TwitterController);

     TwitterController.$inject = ['TwitterService'];

     function TwitterController(TwitterService) {
      
        var vm = this;
        vm.tweets = [];
        vm.message;

	     vm.buscarTweetsByUsername = function(username){

           vm.message = "";
        
           TwitterService.listarTweets(username).then(function(res) {
            vm.tweets = res.data;

            if(vm.tweets.length == 0){
            
                 vm.message = "Nenhuma Informação Encontrada"
            }
         })
	       };
        
        vm.loggarTwets = function(){
         TwitterService.logarTwittes(setInfoLogTwets()).then(function(){
            vm.message = "Informações Logadas Com Sucesso!";
            vm.tweets.length = 0;
         })
        };
         
        function setInfoLogTwets(){
          var infLogTweets = [];
          for(var i = 0; i < vm.tweets.length; i++){
             infLogTweets.push(angular.copy(
                criarInfoLog( 
                    vm.tweets[i].id, vm.tweets[i].fromUser, vm.tweets[i].user.name, vm.tweets[i].text, vm.tweets[i].createdAt,  vm.tweets[i].user.profileUrl
                    )
                )
            );
          }
         return infLogTweets;
        };


        var criarInfoLog = function(id, fromUser, userName, text, createdAt, profileUrl){
            return {
              id:id,
              fromUser:fromUser,
              userName:userName,
              text:text,
              createdAt:createdAt,
              profileUrl:profileUrl
            };
        };

      };

  })();