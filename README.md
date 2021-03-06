# jtimeago [![Build Status](https://travis-ci.com/dernasherbrezon/jtimeago.svg?branch=master)](https://travis-ci.com/dernasherbrezon/jtimeago) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.aerse%3Ajtimeago&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.aerse%3Ajtimeago)

Tag lib for various date formatting:
* "Time ago". Examples: 1 seconds ago, 2 months ago, just now
* Interval. Examples: 2 months, 5 years, 1 year

## Usage

Include dependency:

```
		<dependency>
			<groupId>com.aerse</groupId>
			<artifactId>jtimeago</artifactId>
			<version>1.3</version>
		</dependency>
```

Configure taglib:

```
<%@ taglib prefix="ta" uri="https://github.com/dernasherbrezon/jtimeago" %>
```

### Time ago

Use as normal JSTL formatDate:

```
<ta:formatDate value="${comment.date}" pattern="dd MMM yyyy HH:mm" />
```

Supported configuration parameters:
* value. Required. java.util.Date to format
* pattern. Required. Pattern for SimpleDateFormat. Used for more than one day ago dates.
* timeZone. Optional. String or java.util.TimeZone
* var. Optional. Output into var with defined scope.
* scope. Optional. scope for var

### Interval

Format "years":

```
<ta:formatYear value="10" />
```

Supported configuration parameters:
* value. Required. Number.
* var. Optional. Output into var with defined scope.
* scope. Optional. scope for var

Format "months":

```
<ta:formatMonth value="10" />
```

Supported configuration parameters:
* value. Required. Number.
* var. Optional. Output into var with defined scope.
* scope. Optional. scope for var
