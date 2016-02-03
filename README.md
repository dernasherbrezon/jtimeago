# jtimeago
Tag lib for "Time ago" date formatting

## Usage

Include dependency:

```
		<dependency>
			<groupId>com.aerse</groupId>
			<artifactId>jtimeago</artifactId>
		</dependency>
```

Configure taglib:

```
<%@ taglib prefix="ta" uri="https://github.com/dernasherbrezon/jtimeago" %>
```

And use as normal JSTL formatDate:

```
<ta:formatDate value="${comment.date}" pattern="dd MMM yyyy HH:mm" />
```

Supported configuration parameters:
* value. Required. java.util.Date to format
* pattern. Required. Pattern for SimpleDateFormat. Used for more than one day ago dates.
* timeZone. Optional. String or java.util.TimeZone
* var. Optional. Output into var with defined scope.
* scope. Optional. scope for var