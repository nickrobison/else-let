# else-let

A Clojure library that adds an `else-let` macro for easily handling fallback behavior in the faces of `nil` values.

Inspired by Java's `Optional.orElseGet()` method, this macro evaluates the provided let statement and attempts to bind the variable to the first provided form,
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

FIXME

## License

Copyright © 2018 Nick Robison

Distributed under the Eclipse Public License version 1.0
