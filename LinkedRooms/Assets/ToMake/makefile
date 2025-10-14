OPTS=-Wall -Wextra -Wno-unused-parameter -Wno-unused-variable -Wno-unused-but-set-variable -Werror -std=c17 -Wpedantic -O0 -g
SETOPTS=-Wall -Wextra -Wno-unused-parameter -Wno-unused-variable -Wno-unused-but-set-variable -Werror -std=c17 -Wpedantic -O0


all: LinkedRooms

LinkedRooms: backrooms.o Lists.o
	gcc $^ -o $@ $(OPTS)

backrooms.o: backrooms.c Lists.h
	gcc $< -c -o $@ $(OPTS)

Lists.o: Lists.c Lists.h
	gcc $< -c -o $@ $(SETOPTS)

clean:
	rm -f *.o LinkedRooms