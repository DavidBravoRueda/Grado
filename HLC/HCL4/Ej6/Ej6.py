def hacer_sandwich(*ingredientes):
    print("Making a sandwich with the following items:")
    for ingrediente in ingredientes:
        print(f"- {ingrediente}")
    print("\n") 

hacer_sandwich("mayonnaise", "tuna", "lettuce", "ham")
hacer_sandwich("ham", "cheese")
hacer_sandwich("cheese", "bacon", "tuna")
