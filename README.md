[![Build Status](https://travis-ci.org/nickrobison/else-let.svg?branch=master)](https://travis-ci.org/nickrobison/else-let)
[![License](https://img.shields.io/badge/License-EPL%201.0-red.svg)](https://opensource.org/licenses/EPL-1.0)
[![Clojars Project](https://img.shields.io/clojars/v/else-let.svg)](https://clojars.org/else-let)


# else-let

A Clojure library that adds an `else-let` macro for conditional binding in the face of `nil` values.

Inspired by Java's `Optional.orElseGet()` method, this macro evaluates the provided let statement and attempts to bind the variables to the first provided form,
if that form returns `nil`, `else-let` will bind the value of the second form.

Example:

```clojure
(else-let [x "first-value" "fallback"
           y nil "will bind this value to y"
           z nil nil]
           (vector x y (nil? z)))

;["first-value" "will bind this value to y" true]
``` 

## Usage

### 

```clojure
[else-let "0.1.0"]
```

### Maven
```xml
<dependency>
            <groupId>else-let</groupId>
            <artifactId>else-let</artifactId>
            <version>0.1.0</version>
        </dependency>
```

## License

Copyright © 2018 Nick Robison

Distributed under the Eclipse Public License version 1.0
