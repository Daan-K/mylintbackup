var app = require('express')();
var bodyParser = require('body-parser');
var exec = require('child_process').spawn;

app.use(bodyParser.json());

// This should be removed
app.get('/', function (req, res) {
    res.send('Nothing here...');
});

// Triggered by a new pull request
app.post('/new-pr', function (req, res) {
    console.log(req.body);
    var args = [req.body.base.repo.full_name, req.body.head.repo.full_name, req.body.pull_request.head.ref, req.body.number];
    console.log(args);
    
    res.send('OK');
    
    // Run the linter
    // spawn('./linter', args);
});

var server = app.listen(3000, function () {

    var host = server.address().address;
    var port = server.address().port;

    console.log('App listening at http://%s:%s', host, port);

});
