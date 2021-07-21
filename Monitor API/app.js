const express = require('express');
app = express();
const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/argilytics');
const Reading = require('./model/reading');

app.get("/reading", (req, res) => {
    console.log("GET /reading: ");
    Reading.find({}, null, { sort: {timestamp: 'descending'}, limit: 1 }, (err, docs) => {
        if (err) {
            console.log(err);
            return res.status(500).json({ fail: "error", error: err });
        }
        if (docs.length < 1) {
            return res.status(500).json(null);
        }
        const reading = docs[0];
        console.log(reading);
        return res.status(200).json({
            timestamp: reading.timestamp,
            temprature: reading.temprature,
        });
    });
});
app.use((req, res) => {
    return res.status(404).json({
        fail: "Not Found"
    });
});

const port = 9001
app.listen(port, () => {
    console.log(`Monitor API server is running http://localhost:${port}/`);
});