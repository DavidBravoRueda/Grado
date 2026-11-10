def print_models(unprinted_designs, completed_models):
    while unprinted_designs:
        current_design = unprinted_designs.pop(0)
        print(f"Printing model {current_design}")
        completed_models.append(current_design)

def show_completed_models(completed_models):
    for model in completed_models:
        print(model)
