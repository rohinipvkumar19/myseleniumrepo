$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("C:/Users/MYPC/workspace/CucumberProject/src/test/resources/com/qtpselenium/rediff/Login.feature");
formatter.feature({
  "name": "Logging into Rediff Money",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Logging into Rediff Money",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.step({
  "name": "I open \u003cBrowser\u003e",
  "keyword": "Given "
});
formatter.step({
  "name": "I navigate to loginURL",
  "keyword": "And "
});
formatter.step({
  "name": "I Login inside application",
  "keyword": "And ",
  "rows": [
    {
      "cells": [
        "Username",
        "ashishthakur1983"
      ]
    },
    {
      "cells": [
        "Password",
        "pass@1234"
      ]
    }
  ]
});
formatter.step({
  "name": "Login should be \u003cResult\u003e",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Browser",
        "Result"
      ]
    },
    {
      "cells": [
        "Mozilla",
        "Success"
      ]
    },
    {
      "cells": [
        "Chrome",
        "Success"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Logging into Rediff Money",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@Login"
    },
    {
      "name": "@Login"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I open Chrome",
  "keyword": "Given "
});
formatter.match({
  "location": "GenericSteps.open_Browser(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I navigate to loginURL",
  "keyword": "And "
});
formatter.match({
  "location": "GenericSteps.navigate_to_url(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I Login inside application",
  "rows": [
    {
      "cells": [
        "Username",
        "ashishthakur1983"
      ]
    },
    {
      "cells": [
        "Password",
        "pass@1234"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "ApplicationSteps.login(String,String\u003e)"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.CucumberProject.webDriver.WebConnector.type(WebConnector.java:118)\r\n\tat com.CucumberProject.webDriver.WebConnector.Login(WebConnector.java:139)\r\n\tat com.CucumberProject.steps.ApplicationSteps.login(ApplicationSteps.java:33)\r\n\tat ✽.I Login inside application(C:/Users/MYPC/workspace/CucumberProject/src/test/resources/com/qtpselenium/rediff/Login.feature:26)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Login should be Success",
  "keyword": "Then "
});
formatter.match({
  "location": "ApplicationSteps.ValidateLogin(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});