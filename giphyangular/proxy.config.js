const PROXY_CONFIG = [
    {
        context: ['/**'],
        target: 'http://giphy-production.up.railway.app',
        secure: false,
        logLevel: 'debug'
    }
]
module.exports = PROXY_CONFIG;