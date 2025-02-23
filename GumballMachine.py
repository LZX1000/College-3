import random

def main() -> None:
    colors = ["Berry-Blue", "Apple-Green","Banana-Yellow", "Cherry-Red", "Clementine-Orange", "Coal"]
    collection = []

    while True:
        response = input("Enter a smiley face to play or 'exit' to quit: ")
        print()

        if response == ":)" or response == "(:":
            random_color = random.choice(colors)

            if random_color == "Coal":
                print(f"The elves ransaked your collection and stole all your gumballs!")
                collection.clear()
            else:
                print(f"Congratulations! You got a {random_color} gumball!")
                collection.append(random_color)
        elif response.lower() == "exit":
            print("Goodbye!")

            break

if __name__ == "__main__":
    main()