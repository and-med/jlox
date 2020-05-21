## Challenge 1

```
expr -> expr call
expr -> expr dot
expr -> expr "," expr
expr -> IDENTIFIER
expr -> NUMBER
call -> "(" expr ")"
call -> "(" ")"
call -> call call
dot  -> "." IDENTIFIER
dot  -> dot dot
```