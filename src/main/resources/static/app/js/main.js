$(function(){
    $('#set-local-storage').on('click', function(){
        CrossStorageHub.init([
            {origin: /http:\/\/localhost:8081$/, allow: ['get', 'set', 'del', 'getKeys', 'clear']},
            {origin: /http:\/\/localhost:8080$/, allow: ['get', 'set', 'del', 'getKeys', 'clear']}
        ]);

        var storage = new CrossStorageClient('http://localhost:8081');

        storage.onConnect().then(function() {
            return storage.set('newKey', '11');
        });
    });
});