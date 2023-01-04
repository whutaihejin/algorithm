# scan all source file with suffix '.cc or .c'
src := $(sort $(wildcard *.cc *.c *.s))

# pattern replacement: '%.cc => % and %.c => %'
target := $(patsubst %.s, %, $(src:.s=))

all: $(target)
	@echo "target => " $(target)

% : %.s
	as $< -o $@.o
	ld $@.o -o $@

% : %.cc
	$(CXX) -std=c++11 -g -O0 $< -o $@

% : %.c
	$(CC) -std=c11 -g -O0 $< -o $@

clean:
	rm -rf *.o $(target)