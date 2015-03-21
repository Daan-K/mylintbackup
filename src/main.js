var app = require('express')();
var bodyParser = require('body-parser');
var prs = [];

app.use(bodyParser.json());

app.get('/', function (req, res) {
    res.send('Hello World!');
});

app.get('/open-prs', function (req, res) {
    res.send(prs);
});

app.post('/new-pr', function (req, res) {
    console.log(req.body);
    prs.push(req.body);
    res.send('OK');
});

var server = app.listen(3000, function () {

    var host = server.address().address;
    var port = server.address().port;

    console.log('Example app listening at http://%s:%s', host, port);

});
