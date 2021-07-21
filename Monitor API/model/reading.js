const mongoose = require('mongoose');

const schema = mongoose.Schema({
    timestamp: Date,
    temprature: Number,
});

module.exports = mongoose.model('Reading', schema);