var app = require('express')();
var bodyParser = require('body-parser');
var exec = require('child_process').spawn;

app.use(bodyParser.json());

app.get('/', function (req, res) {
    res.send('Nothing here...');
});

// This is used for debugging and should be removed later on
var prs = [];
app.get('/open-prs', function (req, res) {
    res.send(prs);
});

// Triggered by a new pull request
app.post('/new-pr', function (req, res) {
    console.log(req.body);asdf
    prs.push(req.body);
    res.send('OK');
    
    // Run the linter
    // spawn('./linter', ['arg1, arg2']);
});

var server = app.listen(3000, function () {

    var host = server.address().address;
    var port = server.address().port;

    console.log('App listening at http://%s:%s', host, port);

});
