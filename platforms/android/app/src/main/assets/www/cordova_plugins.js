cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
  {
    "id": "my-cordova-plugin.plugin",
    "file": "plugins/my-cordova-plugin/www/plugin.js",
    "pluginId": "my-cordova-plugin",
    "clobbers": [
      "MyCordovaPlugin"
    ],
    "runs": true
  }
];
module.exports.metadata = 
// TOP OF METADATA
{
  "cordova-plugin-whitelist": "1.3.3",
  "my-cordova-plugin": "1.0.0"
};
// BOTTOM OF METADATA
});