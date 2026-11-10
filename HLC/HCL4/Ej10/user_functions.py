def build_profile(location, field, first_name, last_name, **user_info):
    profile = {
        "location": location,
        "field": field,
        "first_name": first_name,
        "last_name": last_name
    }
    profile.update(user_info)
    return profile
