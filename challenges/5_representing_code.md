## Challenge 5

```
expr -> expr call
expr -> expr dot
expr -> IDENTIFIER
expr -> NUMBER
call -> "(" arg ")"
call -> "(" ")"
dot  -> "." IDENTIFIER
arg  -> arg "," arg
arg  -> expr
```