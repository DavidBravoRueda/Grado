def build_profile (first, last, **user_info):
    profile = {}
    profile['first_name'] = first
    profile['last_name'] = last
    for key, value in user_info.items():
        profile[key] = value
    return profile

mi_perfil = build_profile(
    location = 'torremolinos', 
    field = 'computing', 
    email = 'javi@gmail.com', 
    pet_name = 'niko', 
    first = 'javier', last = 'bueno')

print(mi_perfil)