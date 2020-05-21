default: jlox

generate_ast:
	@ $(MAKE) -f util/java.make DIR=java PACKAGE=tool
	@ java -cp build/java com.h0neyman.tool.GenerateAst \
					java/com/h0neyman/lox

jlox:generate_ast
	@ $(MAKE) -f util/java.make DIR=java PACKAGE=lox
