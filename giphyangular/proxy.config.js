const PROXY_CONFIG = [
    {
        context: ['/**'],
        target: 'giphy-production.up.railway.app',
        secure: false,
        logLevel: 'debug'
    }
]
module.exports = PROXY_CONFIG;