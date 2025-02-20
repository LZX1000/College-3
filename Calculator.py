def main() -> None:
    running: bool = True

    while running:
        while True:
            parts = input("Enter math need done: ").split(" ")

            if len(parts) == 1:
                if parts[0].lower() == "exit":
                    print("Goodbye!")

                    running = False
            elif len(parts) == 2 and parts[0].isnumeric() and parts[1].isnumeric():
                number1 = float(parts[0])
                number2 = float(parts[1])

                operator = input("Enter the operator: ")[0]

                break
            elif len(parts) == 3 and parts[0].isnumeric() and parts[2].isnumeric():
                number1 = float(parts[0])
                number2 = float(parts[2])

                operator = parts[1][0]

                break
            else:
                print("Invalid input!")

        try:
            print("Result: " + str(eval(f"{number1} {operator} {number2}")))
        except Exception as e:
            print("Error: " + str(e))

if __name__ == "__main__":
    main()