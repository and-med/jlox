package com.h0neyman.lox;

import com.h0neyman.lox.Expr.Assign;
import com.h0neyman.lox.Expr.Binary;
import com.h0neyman.lox.Expr.Grouping;
import com.h0neyman.lox.Expr.Literal;
import com.h0neyman.lox.Expr.Unary;
import com.h0neyman.lox.Expr.Variable;

public class RpnPrinter implements Expr.Visitor<String> {
    String print(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public String visitBinaryExpr(Binary expr) {
        return reversePrint(expr.operator.lexeme, expr.left, expr.right);
    }

    @Override
    public String visitGroupingExpr(Grouping expr) {
        return expr.expression.accept(this);
    }

    @Override
    public String visitLiteralExpr(Literal expr) {
        if (expr.value == null)
            return "nil";
        return expr.value.toString();
    }

    @Override
    public String visitUnaryExpr(Unary expr) {
        return reversePrint(expr.operator.lexeme, expr.right);
    }

    @Override
    public String visitVariableExpr(Variable expr) {
        return expr.name.toString();
    }

    @Override
    public String visitAssignExpr(Assign expr) {
        return reversePrint(expr.name.lexeme, expr.value);
    }

    private String reversePrint(String name, Expr... exprs) {
        StringBuilder builder = new StringBuilder();

        for (Expr expr : exprs) {
            builder.append(expr.accept(this)).append(" ");
        }
        builder.append(name);

        return builder.toString();
    }

    public static void main(String[] args) {
        Expr expression = new Expr.Binary(
            new Expr.Binary(
                new Expr.Literal(1),
                new Token(TokenType.PLUS, "+", null, 1), 
                new Expr.Literal(2)), 
            new Token(TokenType.STAR, "*", null, 1),
            new Expr.Binary(
                new Expr.Literal(4),
                new Token(TokenType.MINUS, "-", null, 1), 
                new Expr.Literal(3)));

        System.out.println(new RpnPrinter().print(expression));
    }
}